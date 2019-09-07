<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

    <title>${title}</title>


    <!-- Bootstrap core CSS -->
    <link href="../../bootstrap-4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
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
          <li class="nav-item ">
            <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="/consoles/">Consoles</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="/videogames/">Videogames</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Sort by</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="#">Best selling game</a>
              <a class="dropdown-item" href="#">Games by year</a>
              <a class="dropdown-item" href="#">Consoles by units sold</a>
            </div>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <a class="btn btn-outline-success my-2 my-sm-0" href="/consoles/creation" role="button">Add a new Video game</a>
        </form>
      </div>
    </nav>

    <main role="main" class="container">

      <div class="starter-template">
        <h1>List of the consoles</h1>

        <table class="table table-hover table-bordered">
          <thead class="thead-dark">
          <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Developer</th>
            <th scope="col">Generation</th>
            <th scope="col">Consoles type</th>
            <th scope="col">Released date</th>
            <th scope="col">Discontinued date</th>
            <th scope="col">Lifespan</th>
            <th scope="col">Units sold</th>
          </tr>
          </thead>

          <tbody>

          <#list consoles as console >


          <tr>
            <th scope="row">1</th>
            <td>${console.name}</td>
            <td>${console.developer}</td>
            <td>${console.generation}</td>
            <td>${console.consoleType}</td>
            <td>${console.releasedDate?date}</td>
            <td>${console.discontinuedDate?date}</td>
            <td>${console.lifespan}</td>
            <td>${console.unitsSold}</td>
          </tr>

          </#list>
          </tbody>
        </table>

      </div>

    </main><!-- /.container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../bootstrap-4.3.1/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../bootstrap-4.3.1/assets/js/vendor/popper.min.js"></script>
    <script src="../../bootstrap-4.3.1/dist/js/bootstrap.min.js"></script>
  </body>
</html>
