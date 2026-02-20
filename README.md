# month-number

I really wanted to share this little project.

Yesterday I had a random thought:  
Is there a mathematical formula that, if you feed it a month name as a string, can *compute* which month number it is — purely from the letters?
So I brute-forced roughly **7 trillion formulas** in 24 hours...
And one of them works 😅

The result is a tiny deterministic function that takes the first three letters of any English month name and instantly computes its correct month number.

It’s:

- **O(1) time**
- **O(1) space**
- Zero lookup storage
- Pure arithmetic + hashing

It feels slightly unnecessary. But yet again, as an exercise it flexes what can be done.

Sometimes you brute-force the universe…  
and it answers.