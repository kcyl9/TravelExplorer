# TravelExplorer
TravelExplorer is an Android app that records the countries that the user has travelled to, calculating the amount of the world that they have explored. 
This app is my final project for CS50x and was written using Java on Android Studio.

## Preview


## Features and Implementation
- Imports REST Countries API using Android Volley to create a list of regions and countries
- Parses the given JSON information into name, alpha-3-code, capital, population, and flag url fields
- Processes svg file of each country's flag using Glide and Android SVG libraries
- Allows user to mark country as explored or not
- Calculates the amount of countries explored and presents that as a fraction and percentage

## Libraries and APIs Used
- [Android SVG Library](http://bigbadaboom.github.io/androidsvg/)
- [Android Volley HTTP Library](https://developer.android.com/training/volley)
- [Glide Library](https://github.com/bumptech/glide)
- [Rest Countries API](https://restcountries.eu/)
- [SVG Image Loader Plugins](https://github.com/kirich1409/SvgGlidePlugins)
