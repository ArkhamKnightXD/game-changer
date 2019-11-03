<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>${title}</title>

  <link href="../../bootstrap-4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

  <link href="../../font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">

  <link href="../../bootstrap-4.3.1/style/style.css" rel="stylesheet">

</head>

<body>

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <a class="navbar-brand" href="#">Arkham-Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/consoles/">Consoles</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link " href="/videogames/">Videogames</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="/admin">Admin</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Sort by</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="/videogames/showVideogame">Best selling games</a>
          <a class="dropdown-item" href="/consoles/showHandheldConsole">Best selling handheld consoles</a>
          <a class="dropdown-item" href="/consoles/showHomeConsole">Best selling home consoles</a>
        </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <form class="form-inline my-2 my-lg-0">
        <a class="btn btn-outline-success my-2 my-sm-0" href="/videogames/creation" role="button">Add a new Video game</a>
      </form>
    </form>
  </div>
</nav>

<h1 class="jumbotron text-center">List of the videogames</h1>

<main role="main" class="container">

  <div class="starter-template">

    <table class="table table-hover table-bordered">
      <thead class="thead-dark">
      <tr>
        <th scope="col">#</th>
        <th scope="col">Cover</th>
        <th scope="col">Name</th>
        <th scope="col">Developer</th>
        <th scope="col">Genre</th>
        <th scope="col">Released date</th>
        <th scope="col">Units sold</th>
        <th scope="col">Games mode</th>
        <th scope="col">Rating</th>
        <th scope="col">Options</th>
      </tr>
      </thead>

      <tbody>
      <#list videogames as videogame >

      <tr>
        <th scope="row">${videogame.id}</th>
        <td><a href="/videogames/show/?id=${videogame.id}"><img src="../../bootstrap-4.3.1/assets/img/${videogame.image}" width="110px" height="110px"></a></td>
        <td>${videogame.name}</td>
        <td>${videogame.developer}</td>
        <td>${videogame.genre}</td>
        <td>${videogame.releasedDate?date}</td>
        <td>${videogame.unitsSold}</td>
        <td>${videogame.gameModes}</td>
        <td>${videogame.rating}</td>
        <td>
          <a href="/videogames/edition/?id=${videogame.id}">  <i class="fa fa-edit" style="font-size:25px"></i></a>
          <a href="/videogames/delete/?id=${videogame.id}">  <i class="fa fa-trash" style="font-size:25px;color:red"></i> </a>
        </td>
      </tr>

      </#list>
      </tbody>
    </table>

  </div>

</main>
<footer class="footer-container-1">
  <p class="float-right"><a href="#">Back to top</a></p>
  <p class="logo">&copy; Arkham-Store 2019</p>
</footer>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../bootstrap-4.3.1/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../bootstrap-4.3.1/assets/js/vendor/popper.min.js"></script>
<script src="../../bootstrap-4.3.1/dist/js/bootstrap.min.js"></script>
</body>
</html>
