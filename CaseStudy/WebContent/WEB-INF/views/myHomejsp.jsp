<!DOCTYPE html>
<html lang="en">
<head>
<title>Raising Kids</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #666;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: purple;
}

/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 30%;
  height: 300px; /* only for demonstration, should be removed */
  background: #ccc;
  padding: 20px;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 0;
}

article {
  float: left;
  padding: 20px;
  width: 70%;
  background-color: #yellow;
  height: 300px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the footer */
footer {
  background-color: #777;
  padding: 10px;
  text-align: center;
  color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}
</style>
</head>
<body>

<h2>Raising Kids (Parenting Tips)</h2>
<p>No one would argue that raising children of character demands time and big effort. While having children may be doing what comes naturally, being a good parent is much more complicated.
 If you want to know how to raise a child, follow these steps.</p>

<header>
  <h2>Articles</h2>
</header>

<section>
  <nav>
    <ul>
      <li><a href="#">Education</a></li>
      <li><a href="#">Behaviour</a></li>
      <li><a href="#">Tips</a></li>
    </ul>
  </nav>
  
  <article>
    <h1>Education</h1>
    <p>The best way to teach a child to read is by making it enjoyable. Here are ten simple steps to help your child build essential phonics and reading</p>
    <p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>
  </article>
</section>

<footer>
  <p>Footer</p>
</footer>

</body>
</html>
