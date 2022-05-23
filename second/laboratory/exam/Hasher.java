package second.laboratory.exam;

public interface Hasher {
    public byte[] hash(byte[] prevHash, String[] transactions);
}
