package dz.home.commun.parsing;


import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;


public class UnicodeBOMInputStream extends InputStream
{
	  private final PushbackInputStream in;
	  private final BOM                 bom;
	  private       boolean             skipped = false;
  public static final class BOM
  {
   
    public static final BOM NONE = new BOM(new byte[]{},"NONE");
    public static final BOM UTF_8 = new BOM(new byte[]{(byte)0xEF,
                                                       (byte)0xBB,
                                                       (byte)0xBF},"UTF-8");
    
    public final String toString()
    {
      return description;
    }

    /**
     * Returns the bytes corresponding to this <code>BOM</code> value.
     */
    public final byte[] getBytes()
    {
      final int     length = bytes.length;
      final byte[]  result = new byte[length];

      // Make a defensive copy
      System.arraycopy(bytes,0,result,0,length);

      return result;
    }

    private BOM(final byte bom[], final String description)
    {
      assert(bom != null)               : "invalid BOM: null is not allowed";
      assert(description != null)       : "invalid description: null is not allowed";
      assert(description.length() != 0) : "invalid description: empty string is not allowed";

      this.bytes          = bom;
      this.description  = description;
    }

            final byte    bytes[];
    private final String  description;

  } // BOM

 
  public UnicodeBOMInputStream(final InputStream inputStream) throws  NullPointerException,
                                                                      IOException

  {
    if (inputStream == null)
      throw new NullPointerException("invalid input stream: null is not allowed");

    in = new PushbackInputStream(inputStream,4);

    final byte  bom[] = new byte[4];
    final int   read  = in.read(bom);

    switch(read)
    {
     
      case 4:
        if ((bom[0] == (byte)0xEF) &&
            (bom[1] == (byte)0xBB) &&
            (bom[2] == (byte)0xBF)  )
        {
          this.bom = BOM.UTF_8;
          break;
        }
      default:
        this.bom = BOM.NONE;
        break;
    }

    if (read > 0)
      in.unread(bom,0,read);
  }

  
  public final BOM getBOM()
  {
   
    return bom;
  }

 
  public final synchronized UnicodeBOMInputStream skipBOM() throws IOException
  {
    if (!skipped)
    {
      in.skip(bom.bytes.length);
      skipped = true;
    }
    return this;
  }

 
  public int read() throws IOException
  {
    return in.read();
  }

 
  public int read(final byte b[]) throws  IOException,
                                          NullPointerException
  {
    return in.read(b,0,b.length);
  }

 
  public int read(final byte b[],
                  final int off,
                  final int len) throws IOException,
                                        NullPointerException
  {
    return in.read(b,off,len);
  }

  
  public long skip(final long n) throws IOException
  {
    return in.skip(n);
  }

  public int available() throws IOException
  {
    return in.available();
  }
  public void close() throws IOException
  {
    in.close();
  }

  public synchronized void mark(final int readlimit)
  {
    in.mark(readlimit);
  }

 
  public synchronized void reset() throws IOException
  {
    in.reset();
  }

  public boolean markSupported() 
  {
    return in.markSupported();
  }



}