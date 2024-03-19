public class SlothValue {

    private Object value;
    private SlothType type;

    SlothValue(String value) {
        this.value = value;
        this.type = SlothType.STRING;
    }

    SlothValue(int value) {
        this.value = value;
        this.type = SlothType.INT;
    }

    SlothValue(double value) {
        this.value = value;
        this.type = SlothType.DOUBLE;
    }

    SlothValue(boolean value) {
        this.value = value;
        this.type = SlothType.BOOLEAN;

    }

    @Override
    public String toString() {
        switch (type) {
            case STRING -> {
                return (String) this.value;
            }
            case INT -> {
                return ((Integer) this.value).toString();
            }
            case DOUBLE -> {
                return ((Double) this.value).toString();
            }
            case BOOLEAN -> {
                return ((Boolean) this.value).toString();
            }
        }
        return null;
    }

    public int toInt() {
        switch (type) {
            case STRING, BOOLEAN -> {
                try {
                    throw new Exception("Invalid type conversion");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            case INT, DOUBLE -> {
                return (int) this.value;
            }
        }
        return 0;
    }

    public double toReal() {
        switch (type) {
            case STRING, BOOLEAN -> {
                try {
                    throw new Exception("Invalid type conversion");
                } catch (Exception e) {
                    //System.out.println(type);
                    throw new RuntimeException(e);
                }
            }
            case INT -> {
                return ((Number)(this.value)).doubleValue();
            }
            case DOUBLE -> {
                return (double) this.value;
            }
        }
        return 0;
    }

    public boolean toBool() {
        switch (type) {
            case STRING, DOUBLE, INT -> {
                try {
                    throw new Exception("Invalid type conversion");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            case BOOLEAN -> {
                return (boolean) this.value;
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    public SlothType getType() {
        return this.type;
    }
}