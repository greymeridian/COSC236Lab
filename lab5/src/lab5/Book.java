package lab5;

/**
 * COSC236 Lab 05
 * Part 3 (Ronny): Added the Book interface for titles, availability,
 * and text output.
 * @author Ronald Lorette 300294189
 * @since 11-18-2026
 * @version 1.0
 */

public interface Book {
	public String toString();
	public void setIsAvailable(boolean isAvailable);
	public boolean getIsAvailable();
	public String getTitle();
}
