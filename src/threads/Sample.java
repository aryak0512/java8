package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Sample {

	private int x;

	private ReadWriteLock rw_lock = new ReentrantReadWriteLock();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void incr() {

		Lock lock = rw_lock.writeLock();
		lock.lock();

		/** operation to be done after lock is acquired **/
		int y = this.x;

		try {

			y++;

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}

			setX(y);

		} catch (Exception e) {

			System.err.println("Exception occured.");
			e.printStackTrace();

		} finally {

			/** operation done and lock is released **/
			lock.unlock();
		}

	}

}
