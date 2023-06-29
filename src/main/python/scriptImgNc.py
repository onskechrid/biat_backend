import cv2
import pytesseract
from PIL import Image

# Load the image
image = cv2.imread('C:\\Users\\onske\\Desktop\\biat_backend\\target\\static\\files\\C1.jpg')

# Resize the image (optional)
resized_image = cv2.resize(image, None, fx=1.5, fy=1.5)  # Adjust the scale factor as needed

# Convert the resized image to grayscale
gray_image = cv2.cvtColor(resized_image, cv2.COLOR_BGR2GRAY)

# Apply denoising (optional)
denoised_image = cv2.fastNlMeansDenoising(gray_image)

# Apply thresholding to enhance text (optional)
_, thresholded_image = cv2.threshold(denoised_image, 0, 255, cv2.THRESH_BINARY + cv2.THRESH_OTSU)

# Further image enhancement/filtering as needed
filtered_image = cv2.medianBlur(thresholded_image, 3)  # Apply median blur with kernel size 3

# Save the preprocessed image for verification (optional)
cv2.imwrite('preprocessed_image.jpg', filtered_image)

# Convert the preprocessed image to PIL Image format
preprocessed_image = Image.fromarray(filtered_image)
# Use pytesseract to extract text from the preprocessed image
text = pytesseract.image_to_string(preprocessed_image)
print(text)
