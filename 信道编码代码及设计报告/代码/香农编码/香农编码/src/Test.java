public class Test {
    public static void main(String[] args) {
        ShannonEncoding shannonEncoding = new ShannonEncoding();
        shannonEncoding.getProbability();
        shannonEncoding.codeLetter();
        System.out.println("ƽ���볤:"+shannonEncoding.averageCodingLength());
        System.out.println("����Ч��:"+shannonEncoding.codeEfficiency());
    }
}
