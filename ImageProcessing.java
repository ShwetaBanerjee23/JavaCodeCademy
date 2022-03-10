/* 
This project creates an application which is able to modify images and create 
new images using 2D arrays. It covers stretching the image horizontally, shrinking 
the image vertically, negating the color, applying a color filter, and inverting 
the image. 

It also covers creating an image consisting of randomly colored pixels, placing a 
rectangle in a given image, and using the method to randomly place many rectangles 
in the image.

Concepts used: 2D Arrays
*/

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;

public class ImageProcessing {

	// Image Processing Methods
	public static int[][] trimBorders(int[][] imageTwoD, int pixelCount) {
		// Example Method
		if (imageTwoD.length > pixelCount * 2 && imageTwoD[0].length > pixelCount * 2) {
			int[][] trimmedImg = 
        new int[imageTwoD.length - pixelCount * 2][imageTwoD[0].length - pixelCount * 2];
			for (int i = 0; i < trimmedImg.length; i++) {
				for (int j = 0; j < trimmedImg[i].length; j++) {
					trimmedImg[i][j] = imageTwoD[i + pixelCount][j + pixelCount];
				}
			}
			return trimmedImg;
		} else {
			System.out.println("Cannot trim that many pixels from the given image.");
			return imageTwoD;
		}
	}

	public static int[][] negativeColor(int[][] imageTwoD) {
    /*
    Replaces the color of each pixel in the image with its negative version

    imageTwoD - 2D array of integers corresponding to a given image
    */

    int[][] negated = new int[imageTwoD.length][imageTwoD[0].length];

		for (int i = 0; i < imageTwoD.length; i++) {

      for (int j = 0; j < imageTwoD[0].length; j++) {

        int[] rgba = getRGBAFromPixel(imageTwoD[i][j]);

        // Negating each color component from pixel
        int r = 255 - rgba[0];
        int g = 255 - rgba[1];
        int b = 255 - rgba[2];
        int a = 255 - rgba[3];

        int[] newrgba = new int[] {r, g, b, a};

        int res = getColorIntValFromRGBA(newrgba);

        negated[i][j] = res;
      }
    }
    return negated;
	}
  
	public static int[][] stretchHorizontally(int[][] imageTwoD) {
    /*
    Stretches the image horizontally such that the width is doubled

    imageTwoD - 2D array of integers corresponding to a given image
    */

    int [][] res = new int[imageTwoD.length][imageTwoD[0].length * 2];

		for (int i = 0; i < imageTwoD.length; i++) {

      for (int j = 0; j < imageTwoD[0].length; j++) {

        int it = j * 2;

        res[i][it] = imageTwoD[i][j];
        res[i][it + 1] = imageTwoD[i][j];
      }
    }
    return res;
	}

	public static int[][] shrinkVertically(int[][] imageTwoD) {
    /*
    Shrinks the image vertically such that the height is halved

    imageTwoD - 2D array of integers corresponding to a given image
    */

		int[][] res = new int[imageTwoD.length / 2][imageTwoD[0].length];
		
    for (int i = 0; i < imageTwoD.length; i++) {
      // End one pixel early in case height is odd - to avoid accessing out of 
      // bounds elements
      for (int j = 0; j < imageTwoD[0].length - 1; j++) {
        
        int it = i / 2;
        // even i then append else no
        if (i % 2 == 0) {

          res[it][j] = imageTwoD[i][j];
        
        }
      }
    }
    return res;
	}

	public static int[][] invertImage(int[][] imageTwoD) {
    /*
    Flips the image horizontally and vertically

    imageTwoD - 2D array of integers corresponding to a given image
    */

		int[][] res = new int[imageTwoD.length][imageTwoD[0].length];
    
    for (int i = 0; i < imageTwoD.length; i ++) {
    
      for (int j = 0; j < imageTwoD[0].length; j++) {
    
        res[(imageTwoD.length - 1) - i][(imageTwoD[0].length - 1) - j] = imageTwoD[i][j];
    
      }
    }
		return res;
	}

	public static int[][] colorFilter(int[][] imageTwoD, int redChangeValue, 
                                    int greenChangeValue, int blueChangeValue) {
    /*
    Modifies every pixel in the image by provided R, G, B values as input parameter and 
    ensures that each color value is within the range of 0-255

    imageTwoD - 2D array of integers corresponding to a given image
    redChangeValue - An integer to change the red value by
    greenChangeValue - An integer to change the green value by
    blueChangeValue - An integer to change the blue value by
    */

    int[][] res = new int[imageTwoD.length][imageTwoD[0].length];
    
    for (int i = 0; i < imageTwoD.length; i++) {

      for (int j = 0; j < imageTwoD[0].length; j++) {
        
        int r = (getRGBAFromPixel(imageTwoD[i][j]))[0] + redChangeValue;
        int g = (getRGBAFromPixel(imageTwoD[i][j]))[1] + greenChangeValue;
        int b = (getRGBAFromPixel(imageTwoD[i][j]))[2] + blueChangeValue;
        
        int[] cols; 
        cols = new int[] {r, g, b, getRGBAFromPixel(imageTwoD[i][j])[3]};

        // Checks if any color value is no longer in the range of 0-255 and corrects it, 
        // if necessary
        for (int x = 0; x < 4; x++) {

          if (cols[x] < 0) {
          
            cols[x] = 0;
          
          } else if (cols[x] > 255) {
          
            cols[x] = 255;
          
          }
        }

        int finalCol = getColorIntValFromRGBA(cols);

        res[i][j] = finalCol;
      }
    }
		return res;
	}


	// Painting Methods
	public static int[][] paintRandomImage(int[][] canvas) {
    /*
    Modifies the image passed in by replacing every pixel with a randomly colored pixel

    canvas - 2D array of integers corresponding to a given image
    */

		Random rnd = new Random();

    for (int i = 0; i < canvas.length; i++) {

      for (int j = 0; j < canvas[0].length; j++) {
      
        int rnd1 = rnd.nextInt(256);
        int rnd2 = rnd.nextInt(256);
        int rnd3 = rnd.nextInt(256);

        int[] rnds = {rnd1, rnd2, rnd3, 255};

        canvas[i][j] = getColorIntValFromRGBA(rnds);
      }
    }
		return canvas;
	}

	public static int[][] paintRectangle(int[][] canvas, int width, 
                                       int height, int rowPosition, int colPosition, int color) {
		/*
    Draws a rectangle on a given image using a provided width, height, rowPosition, 
    columnPosition, and color

    canvas - This is the 2D array of integers corresponding to a given image
    width - An integer representing the width of the rectangle to be drawn
    height - An integer representing the height of the rectangle to be drawn
    rowPosition - An integer representing the row in which the rectangle starts in, 
      the rectangle then continues down the column
    colPosition - An integer representing the column in which the rectangle starts in, 
      the rectangle then continues across the row
    color - An integer representing the color that should be used to color the rectangle 
    */

    for (int i = 0; i < canvas.length; i++) {
    
      for (int j = 0; j < canvas[0].length; j++) {
        
        if (i >= rowPosition && i <= (rowPosition + height)) {

          if (j >= colPosition && j <= (colPosition + width)) {
    
            canvas[i][j] = color;
    
          }
        }
      }
    }
		return canvas;
	}

	public static int[][] generateRectangles(int[][] canvas, int numRectangles) {
    /*
    Uses the paintRectangles() method, created above, to generate randomly positioned, 
    sized, and colored rectangles baesd on a given number numRectangles

    canvas - This is the 2D array of integers corresponding to a given image
    numRectangles - An integer used to determine how many randomly generated rectangles are 
      placed in the image
    */

		Random rnd = new Random();

    for (int i = 0; i < numRectangles; i++) {

      // Generating a width less than the width of canvas
      int width = rnd.nextInt(canvas[0].length);
      
      // Generating a height less than the height of canvas
      int height = rnd.nextInt(canvas.length);

      int rowPosition = rnd.nextInt(canvas.length - height);

      int colPosition = rnd.nextInt(canvas[0].length - width);

      int rnd1 = rnd.nextInt(256);
      int rnd2 = rnd.nextInt(256);
      int rnd3 = rnd.nextInt(256);

      int[] rnds = {rnd1, rnd2, rnd3, 255};

      int color = getColorIntValFromRGBA(rnds);

      paintRectangle(canvas, width, height, rowPosition, colPosition, color);
    }
		return canvas;
	}


	// Utility Methods
	public static int[][] imgToTwoD(String inputFileOrLink) {
		try {
			BufferedImage image = null;
			if (inputFileOrLink.substring(0, 4).toLowerCase().equals("http")) {
				URL imageUrl = new URL(inputFileOrLink);
				image = ImageIO.read(imageUrl);
				if (image == null) {
					System.out.println("Failed to get image from provided URL.");
				}
			} else {
				image = ImageIO.read(new File(inputFileOrLink));
			}
			int imgRows = image.getHeight();
			int imgCols = image.getWidth();
			int[][] pixelData = new int[imgRows][imgCols];
			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					pixelData[i][j] = image.getRGB(j, i);
				}
			}
			return pixelData;
		} catch (Exception e) {
			System.out.println("Failed to load image: " + e.getLocalizedMessage());
			return null;
		}
	}
	public static void twoDToImage(int[][] imgData, String fileName) {
		try {
			int imgRows = imgData.length;
			int imgCols = imgData[0].length;
			BufferedImage result = new BufferedImage(imgCols, imgRows, BufferedImage.TYPE_INT_RGB);
			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					result.setRGB(j, i, imgData[i][j]);
				}
			}
			File output = new File(fileName);
			ImageIO.write(result, "jpg", output);
		} catch (Exception e) {
			System.out.println("Failed to save image: " + e.getLocalizedMessage());
		}
	}
	public static int[] getRGBAFromPixel(int pixelColorValue) {
		Color pixelColor = new Color(pixelColorValue);
		return new int[] { pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), pixelColor.getAlpha() };
	}
	public static int getColorIntValFromRGBA(int[] colorData) {
		if (colorData.length == 4) {
			Color color = new Color(colorData[0], colorData[1], colorData[2], colorData[3]);
			return color.getRGB();
		} else {
			System.out.println("Incorrect number of elements in RGBA array.");
			return -1;
		}
	}
	public static void viewImageData(int[][] imageTwoD) {
		if (imageTwoD.length > 3 && imageTwoD[0].length > 3) {
			int[][] rawPixels = new int[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rawPixels[i][j] = imageTwoD[i][j];
				}
			}
			System.out.println("Raw pixel data from the top left corner.");
			System.out.print(Arrays.deepToString(rawPixels).replace("],", "],\n") + "\n");
			int[][][] rgbPixels = new int[3][3][4];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rgbPixels[i][j] = getRGBAFromPixel(imageTwoD[i][j]);
				}
			}
			System.out.println();
			System.out.println("Extracted RGBA pixel data from top the left corner.");
			for (int[][] row : rgbPixels) {
				System.out.print(Arrays.deepToString(row) + System.lineSeparator());
			}
		} else {
			System.out.println("The image is not large enough to extract 9 pixels from the top left corner");
		}
	}

  
  // Testing all methods work as intended
  public static void main(String[] args) {

    // The provided images are apple.jpg, flower.jpg, and kitten.jpg

		int[][] imageData = imgToTwoD("./kitten.jpg");

    // Negating the image and viewing it on screen
    //twoDToImage(negativeColor(imageData), "./kitten.jpg");

    // Stretching horizontally and viewing it on screen
    //twoDToImage(stretchHorizontally(imageData), "./apple.jpg");

    // Shrinking vertically and viewing it on screen
    //twoDToImage(shrinkVertically(imageData), "./apple.jpg");

    // Inverting image and viewing on screen
    //twoDToImage(invertImage(imageData), "./apple.jpg");

    // Applying a color filter and viewing on screen
    //twoDToImage(colorFilter(imageData, 75, -30, 30), "./apple.jpg");
    
		//int[][] trimmed = trimBorders(imageData, 60);
		//twoDToImage(trimmed, "./trimmed_apple.jpg");

    // Applying all filters
		//twoDToImage(stretchHorizontally(shrinkVertically(colorFilter(negativeColor(trimBorders(invertImage(imageData), 50)), 200, 20, 40))), "./apple.jpg");

		// Painting with pixels

    // Painting a random image on a blank canvas
    //int[][] blankCanvas = new int[500][500];
    //twoDToImage(paintRandomImage(blankCanvas), "./random.jpg");

    // Drawing rectangles on an image using provided width, height, rowPosition, columnPosition, and color
    //int[] red = new int[] {255, 0, 0, 255};
    //int col = getColorIntValFromRGBA(red);
    //twoDToImage(paintRectangle(paintRandomImage(blankCanvas), 300, 100, 100, 100, col), "./random.jpg");

    // Drawing a random number of rectangles (numRectangles) with random dimensions and in random places on canvas
    //twoDToImage(generateRectangles(paintRandomImage(blankCanvas), 1000), "./random.jpg");
	}
}
