package sdaishu.baselib.base;

/**
 * Created by cq on 2017/2/27.
 */

public class Action<T> {
    private final String type;
    private final T data;

    Action(String type, T data) {
        this.type = type;
        this.data = data;
    }


    public String getType() {
        return type;
    }

    public T getData() {
        return data;
    }

    public static  class Builder {

        private String type;
        private Object data;

        Builder with(String type) {
            if (type == null) {
                throw new IllegalArgumentException("Type may not be null.");
            }
            this.type = type;
            return this;
        }

        public Builder bundle(Object value) {

            if (value == null) {
                throw new IllegalArgumentException("Value may not be null.");
            }
            this.data=value;
            return this;
        }

        public Action build() {
            if (type == null || type.isEmpty()) {
                throw new IllegalArgumentException("At least one key is required.");
            }
            return new Action(type, data);
        }
    }
}
