package binary;

interface BinaryValue {
    BinaryValue sum(BinaryValue binaryValue1, BinaryValue binaryValue2);
    BinaryValue difference(BinaryValue binaryValue1, BinaryValue binaryValue2);
    BinaryValue multiplication(BinaryValue binaryValue1, BinaryValue binaryValue2);
    BinaryValue division(BinaryValue binaryValue1, BinaryValue binaryValue2);
}
