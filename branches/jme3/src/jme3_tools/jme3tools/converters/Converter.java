package g3dtools.converters;

import java.util.Map;

public interface Converter<T> {
    public T convert(T input, Map<String, String> params);
}
