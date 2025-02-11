package com.ontariotechu.sofe3980U;

public class Binary {
    private String value;

    /**
     * Constructor to initialize a Binary object with a sanitized binary string.
     *
     * @param value The binary string.
     */
    public Binary(String value) {
        this.value = sanitizeBinary(value);
    }

    /**
     * Returns the binary value as a string.
     *
     * @return The binary string.
     */
    public String getValue() {
        return value;
    }

    /**
     * Performs a bitwise OR operation between two binary values.
     *
     * @param a The first binary value.
     * @param b The second binary value.
     * @return A new Binary object with the result of the OR operation.
     */
    public static Binary or(Binary a, Binary b) {
        String binary1 = padBinary(a.getValue(), b.getValue());
        String binary2 = padBinary(b.getValue(), a.getValue());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binary1.length(); i++) {
            result.append(binary1.charAt(i) == '1' || binary2.charAt(i) == '1' ? '1' : '0');
        }
        return new Binary(result.toString());
    }

    /**
     * Performs a bitwise AND operation between two binary values.
     *
     * @param a The first binary value.
     * @param b The second binary value.
     * @return A new Binary object with the result of the AND operation.
     */
    public static Binary and(Binary a, Binary b) {
        String binary1 = padBinary(a.getValue(), b.getValue());
        String binary2 = padBinary(b.getValue(), a.getValue());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binary1.length(); i++) {
            result.append(binary1.charAt(i) == '1' && binary2.charAt(i) == '1' ? '1' : '0');
        }
        return new Binary(result.toString());
    }

    /**
     * Multiplies two binary values using repeated addition.
     *
     * @param a The first binary value.
     * @param b The second binary value.
     * @return A new Binary object with the result of the multiplication.
     */
    public static Binary multiply(Binary a, Binary b) {
        Binary result = new Binary("0");
        String binary1 = a.getValue();
        String binary2 = b.getValue();

        for (int i = binary2.length() - 1; i >= 0; i--) {
            if (binary2.charAt(i) == '1') {
                Binary shifted = new Binary(binary1 + "0".repeat(binary2.length() - 1 - i));
                result = Binary.add(result, shifted);
            }
        }
        return result;
    }

    /**
     * Adds two binary values.
     *
     * @param a The first binary value.
     * @param b The second binary value.
     * @return A new Binary object with the result of the addition.
     */
    public static Binary add(Binary a, Binary b) {
        String binary1 = padBinary(a.getValue(), b.getValue());
        String binary2 = padBinary(b.getValue(), a.getValue());

        StringBuilder result = new StringBuilder();
        int carry = 0;

        for (int i = binary1.length() - 1; i >= 0; i--) {
            int bit1 = binary1.charAt(i) - '0';
            int bit2 = binary2.charAt(i) - '0';
            int sum = bit1 + bit2 + carry;
            result.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) {
            result.append('1');
        }
        return new Binary(result.reverse().toString());
    }

    /**
     * Sanitizes a binary string by removing leading zeros.
     *
     * @param binary The binary string.
     * @return The sanitized binary string.
     */
    private String sanitizeBinary(String binary) {
        // Remove leading zeros but ensure at least one zero remains if the string becomes empty
        String sanitized = binary.replaceAll("^0+(?!$)", "");
        return sanitized.isEmpty() ? "0" : sanitized;
    }

    /**
     * Pads a binary string to match the length of another binary string.
     *
     * @param binary   The binary string to pad.
     * @param reference The reference binary string (used for length).
     * @return The padded binary string.
     */
    private static String padBinary(String binary, String reference) {
        int lengthDifference = reference.length() - binary.length();
        if (lengthDifference > 0) {
            return "0".repeat(lengthDifference) + binary;
        }
        return binary;
    }
}

