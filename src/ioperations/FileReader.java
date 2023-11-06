package ioperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.sql.DataSource;

public class FileReader {

	public static void main(String[] args) {

		File file = new File("abc.txt");

		try (InputStream in = new FileInputStream(file);) {

			int content;

			while ((content = in.read()) != -1) {
				System.out.print((char) content);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Stream<String> getUsers() {

		// instantiate this somehow
		DataSource ds = null;
		
		try {
			
			Connection conn = ds.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement stm = conn.prepareStatement("SELECT id FROM users", ResultSet.TYPE_FORWARD_ONLY);
			// fetch size is what guarantees only 1000 records at the time
			stm.setFetchSize(1000);
			ResultSet rs = stm.executeQuery();

			Iterator<String> sqlIter = new Iterator<>() {
				@Override
				public boolean hasNext() {
					try {
						return rs.next();
					} catch (SQLException e) {
						closeResources(conn, stm, rs);
						throw new RuntimeException("Failed to read record from ResultSet", e);
					}
				}

				@Override
				public String next() {
					try {
						return rs.getString("id");
					} catch (SQLException e) {
						closeResources(conn, stm, rs);
						throw new RuntimeException("Failed to read record from ResultSet", e);
					}
				}
			};

			// turn iterator into a stream
			return StreamSupport.stream(Spliterators.spliteratorUnknownSize(sqlIter,
					Spliterator.NONNULL | Spliterator.ORDERED | Spliterator.IMMUTABLE), false).onClose(() -> {
						// make sure to close resources when done with the stream
						closeResources(conn, stm, rs);
					});

		} catch (SQLException e) {
			
			System.out.println("Failed to process data");
			throw new RuntimeException(e);
		}
	}

	private void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
		try (conn; ps; rs) {
			System.out.println("Resources successfully closed");
		} catch (SQLException e) {
			System.out.println("Failed to properly close database sources : " + e);
		}
	}

}
