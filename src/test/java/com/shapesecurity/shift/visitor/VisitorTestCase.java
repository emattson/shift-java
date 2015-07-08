package com.shapesecurity.shift.visitor;

import junit.framework.TestCase;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class VisitorTestCase extends TestCase {
  private static final String BASE_PATH = System.getenv("CONFIG_DIR") == null ? "src/test/resources" : System.getenv("CONFIG_DIR");

  protected static Path getPath(String path) {
    Path pathObj = Paths.get(BASE_PATH + '/' + path);
    if (Files.exists(pathObj)) {
      return pathObj;
    } else {
      return Paths.get(path);
    }
  }

  @NotNull
  protected static String readFile(@NotNull String path) throws IOException {
    byte[] encoded = Files.readAllBytes(getPath(path));
    return StandardCharsets.UTF_8.decode(ByteBuffer.wrap(encoded)).toString();
  }
}