# RecipeApp

SRA (Simple Recipe App), is a simple recipe app created using [TheMealDB](https://www.themealdb.com/api.php) for the M7019E course taken at Luleå University of Technology during the spring of 2023. 

![appMealCategory](https://github.com/Emn98/RecipeApp/assets/60701147/28c05624-4e4b-472c-9460-d195b7eb6566)
The first fragment presents users with different meal categories that they can click on in order to view recipes associated with the chosen category. This fragment utilizes the "List all meal categories" API call to fetch and display the available categories.

![appRecipesList](https://github.com/Emn98/RecipeApp/assets/60701147/7a2d6cad-642b-4f5d-ae9b-a08e66dfecdf)
The second fragment showcases all the available recipes within a selected category. Users can click on a recipe to view the details of that recipe. The "Filter by Category" API call is utilized to list all recipes belonging to a selected category. 

![appRecipeDetail](https://github.com/Emn98/RecipeApp/assets/60701147/e797fdf9-77c1-473b-99f7-f1019bc65a7c)
The third fragment displays the details of a selected recipe. The app retrieves this information by utilizing the "Lookup full meal details by ID" API call.

![appVideoPlayer](https://github.com/Emn98/RecipeApp/assets/60701147/546772cb-b84e-4a25-bb50-0a93b275c73a)
The fourth fragment contains a YouTube player that allows users to watch a tutorial video on how to make the selected recipe. This fragment is only available if the selected recipe has a valid video ID associated with it.

