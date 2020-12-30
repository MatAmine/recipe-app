package guru.springframework.recipeapp.services.impl;

import guru.springframework.recipeapp.domain.Recipe;
import guru.springframework.recipeapp.repositories.RecipeRepository;
import guru.springframework.recipeapp.services.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImageFile(Long idRecipe, MultipartFile file) {
        log.debug("Received a file");

        Optional<Recipe> recipeOptional = recipeRepository.findById(idRecipe);

        if(recipeOptional.isPresent()) {
            try {
                Recipe recipe = recipeOptional.get();
                Byte[] imgByte = new Byte[file.getBytes().length];

                int i = 0;
                for(byte b : file.getBytes()) {
                    imgByte[i++] = b;
                }

                recipe.setImage(imgByte);
                recipeRepository.save(recipe);
            }
            catch(IOException ex){
                log.error("Error occured : {}", ex.getMessage(), ex);
            }
        }

    }

    @Override
    public byte[] getImageByteByRecipeId(Long recipeId) {
        byte[] result = new byte[0];
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (recipeOptional.isPresent() && recipeOptional.get().getImage() != null) {
            final Recipe recipe = recipeOptional.get();
            result = new byte[recipe.getImage().length];

            int i = 0;
            for (byte b : recipe.getImage()) {
                result[i++] = b;
            }
        }

        return result;
    }
}
