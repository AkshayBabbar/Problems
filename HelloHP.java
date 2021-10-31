public class HelloHP {

    public static void main(String args[]) throws UnsupportedEncodingException {
       
        //Let's first create a ByteBuffer from String
        String content = "It's easy to convert ByteBuffer to String in Java";
        ByteBuffer buffer = ByteBuffer.wrap(content.getBytes("UTF-8"));
       
        // Now let's convert this ByteBuffer to String
        String converted = new String(buffer.array(), "UTF-8");
        
        System.out.println("Original : " + content);
        System.out.println("Converted : " + converted);

    }

}
