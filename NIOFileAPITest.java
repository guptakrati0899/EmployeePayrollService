package employeepayrollservice;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class NIOFileAPITest {

	private static String Home = System.getProperty("user.home");
	private static String PlayWithNio = "TempPlayGround";

	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException {

		// Check File
		Path homePath = Paths.get(Home);
		Assert.assertTrue(Files.exists(homePath));

		// Delete File And Check File Not Exist
		Path playPath = Paths.get(Home + "/" + PlayWithNio);
		if (Files.exists(playPath))
			FileUtils.deleteFiles(playPath.toFile());
		Assert.assertTrue(Files.notExists(playPath));

		Files.createDirectory(playPath);
		Assert.assertTrue(Files.exists(playPath));

		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
			Assert.assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {
			}
			Assert.assertTrue(Files.exists(tempFile));
		});

		// List files , directories With Extension

		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
				.forEach(System.out::println);

	}

}
