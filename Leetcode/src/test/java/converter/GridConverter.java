package converter;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import util.Translate;

public class GridConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && int[][].class.equals(targetType)) {
            return Translate.grid((String) source);
        }
        throw new UnsupportedOperationException();
    }
}
