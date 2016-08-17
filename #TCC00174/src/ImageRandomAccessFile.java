
import exercicios.arquivos.imagerandomaccessfile.ImageRawGrayScale;
import exercicios.arquivos.imagerandomaccessfile.RandomAccessFileIO;
import java.io.IOException;

public class ImageRandomAccessFile {

  public static void main(String[] args) throws IOException {
    ImageRawGrayScale image = new ImageRawGrayScale(64, 64);
    image.load("pic");
    image.print();
    image.save("picnoise");

    RandomAccessFileIO randomAccessFile = new RandomAccessFileIO();
    randomAccessFile.open("picnoise", "rw");
    try {
      randomAccessFile.addNoise(0.1);
    } finally {
      randomAccessFile.close();
    }

    ImageRawGrayScale image2 = new ImageRawGrayScale(64, 64);
    image2.load("picnoise");
    image2.print();
  }
}