package guru.springframework.recipeapp.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveImageFile(Long idRecipe, MultipartFile file);

    byte[] getImageByteByRecipeId(Long id);
}
