package test;

import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import static junit.framework.TestCase.assertNotNull;

class ImageTest {

	@Test
	void test() {
		
		try {
			BufferedImage image = ImageIO.read(new File("C:/work/javaprojects/Tank_60/src/images/bulletD.gif"));
			assertNotNull(image);
			
			BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			//this.getClass()
			assertNotNull(image2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
