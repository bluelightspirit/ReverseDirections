# ReverseDirections

## A Java tool that uses the terminal and takes in a file with text from the user, determines if it's valid, then outputs the directions in reverse order if valid into a new text file

## How does anyone use the tool?

Anyone should be aiming to see the tool that looks like this:
![reversedirections_start](https://user-images.githubusercontent.com/22280271/213864556-513c255c-4cd6-4e10-a394-928fd933525d.jpg)

First, [ReverseDirections.java](https://github.com/bluelightspirit/ReverseDirections/blob/main/ReverseDirections.java) must be downloaded. To do that, it is suggested to download the ZIP file from [Releases](https://github.com/bluelightspirit/ReverseDirections/releases) or copy the repo from a console like Git. It is also suggested to double check if the text-based files are in the same folder if the user plans to use the example text-based files. Then, [ReverseDirections.java](https://github.com/bluelightspirit/ReverseDirections/blob/main/ReverseDirections.java) should be compiled. After that, [ReverseDirections.java](https://github.com/bluelightspirit/ReverseDirections/blob/main/ReverseDirections.java)'s main method should be ran using any IDE that supports Java such as [IntelliJ](https://www.jetbrains.com/idea/download/) or [BlueJ](https://www.bluej.org/).

Then, to use the tool, the user first should start up the tool using that uses the terminal.

After that, the user should put the directions the user wishes to have reversed into a text-based file (.txt, .ml, .xml, etc).
For proper formatting on how the directions must be given in, refer to [`LoudounMuseum.ml`](https://github.com/bluelightspirit/ReverseDirections/blob/main/LoudounMuseum.ml) or these images:

![image](https://user-images.githubusercontent.com/22280271/213865601-c253d735-6fda-4bfb-9148-974fdb21e60c.png)

![image](https://user-images.githubusercontent.com/22280271/213865575-5e4d2192-cfa0-4a55-9c01-07ad05da3dc0.png)

After inputting the directions to match the formatting above, the user should place that file in the same folder as where the program [`ReverseDirections.java`](https://github.com/bluelightspirit/ReverseDirections/blob/main/ReverseDirections.java) that is currently being ran is located.

Then, the user should go back to the terminal where the program [`ReverseDirections.java`](https://github.com/bluelightspirit/ReverseDirections/blob/main/ReverseDirections.java) was being run at and type in the file name and the file format type (such as .txt, .ml, .xml, etc). If the directions were put in a .txt file, it is optional to put ".txt" at the end of the file name.

After that, the user should press "ENTER." They should see this:\
![result](https://user-images.githubusercontent.com/22280271/213865772-23e330e1-e36a-45cd-9200-2af25e645961.jpg)

Then, they should see a file named after the file name they inserted added with "Reverse", and can refer to that as their reverse directions.
If they were using the [`LoudounMuseum.ml`](https://github.com/bluelightspirit/ReverseDirections/blob/main/LoudounMuseum.ml) example, they should see this as the directions put in reverse:

![image](https://user-images.githubusercontent.com/22280271/213886209-851db8ed-16ef-4bae-a01c-1e60a0cdd92b.png)

## I received an error message or my reversed file does not properly have directions in reverse!

If the user receives an error message or their file does not properly have directions in reverse, please double check these three things:
1) The file they inputted the directions in is in the same folder as where [`ReverseDirections.java`](https://github.com/bluelightspirit/ReverseDirections/blob/main/ReverseDirections.java) is running from.
2) They inputted the file name and file format type exactly as the file is named.
3) The file matches the format instructions exactly 1-1.

## How does it work?

These three steps is how the program works:
1) Creates a new text-based file with "Reverse" after the file name the directions shall be reversed from.
2) Reads in the directions from a text-based file.
3) Outputs the directions in reverse order it came from the original text-based file onto the newly created text-based file with "Reverse" after the file name.

## What did I learn?

1) How to read a text-based file.
2) How to create a new file and write text to it.
3) How to use StringBuilder.
4) How to truly reverse directions to the user rather than flip the directions and locations around and assume that will be the directions in reverse.

## Compiling

This program uses solely Java to compile.
