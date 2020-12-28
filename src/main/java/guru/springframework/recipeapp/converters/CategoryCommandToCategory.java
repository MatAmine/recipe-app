package guru.springframework.recipeapp.converters;


import org.springframework.core.convert.converter.Converter;
import com.sun.istack.Nullable;
import guru.springframework.recipeapp.commands.CategoryCommand;
import guru.springframework.recipeapp.domain.Category;
import lombok.Synchronized;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null) {
            return null;
        }

        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
