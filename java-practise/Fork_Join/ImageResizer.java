package Fork_Join;

import java.awt.image.BufferedImage;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ImageResizer extends RecursiveTask<BufferedImage[]> {
  private final BufferedImage[] images;
  private final int start;
  private final int end;
  private final int newWidth;
  private final int newHeight;
  public ImageResizer(BufferedImage[] images, int start, int end, int newWidth, int newHeight) {
    this.images = images;
    this.start = start;
    this.end = end;
    this.newWidth = newWidth;
    this.newHeight = newHeight;
  }
  
  @Override
  protected BufferedImage[] compute() {
    if (end - start <= 10) {
      BufferedImage[] resizedImages = new BufferedImage[end - start];
      for (int i = start; i < end; i++) {
        resizedImages[i - start] = resizeImage(images[i], newWidth, newHeight);
      }
      return resizedImages;
    }

    int middle = (start + end) / 2;

    // Create helpers to resize each half
    ImageResizer leftHalf = new ImageResizer(images, start, middle, newWidth, newHeight);
    ImageResizer rightHalf = new ImageResizer(images, middle, end, newWidth, newHeight);
    // 1. ForkJoinPool:
    // Send the helpers off to resize their images
    leftHalf.fork();
    rightHalf.fork();

    // Wait for the helpers to finish and join their results
    BufferedImage[] leftResults = leftHalf.join();
    BufferedImage[] rightResults = rightHalf.join();

    // Combine the resized images from both halves
    BufferedImage[] allResults = new BufferedImage[end - start];
    System.arraycopy(leftResults, 0, allResults, 0, leftResults.length);
    System.arraycopy(rightResults, 0, allResults, leftResults.length, rightResults.length);
    return allResults;
  }
}