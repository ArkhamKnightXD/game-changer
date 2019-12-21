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
      <a class="navbar-brand" href="/">Arkham-Store</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link active" href="/consoles/admin">Consoles</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="/videogames/admin">Videogames</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="/clients/">Clients</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="/sales/">Store</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="/users/">Users</a>
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
          <a class="btn btn-outline-success my-2 my-sm-0" href="/consoles/creation" role="button">Add a new Console</a>
        </form>
      </div>
    </nav>

    <h1 class="jumbotron text-center">List of the consoles</h1>
    <main role="main" class="container">

      <div class="starter-template">
        <table class="table-hover table table-bordered">
          <thead class="thead-dark">
          <tr>
            <th scope="col">#</th>
            <th scope="col">Picture</th>
            <th scope="col">Name</th>
            <th scope="col">Developer</th>
            <th scope="col">Generation</th>
            <th scope="col">Consoles type</th>
            <th scope="col">Released date</th>
            <th scope="col">Discontinued date</th>
            <th scope="col">Lifespan</th>
            <th scope="col">Units sold</th>
            <th scope="col">Selling price</th>
            <th scope="col">Stock</th>
            <th scope="col">Options</th>
          </tr>
          </thead>

          <tbody>

          <#list consoles as console >

          <tr>
            <th scope="row">${console.id}</th>
            <td><a href="/consoles/show/?id=${console.id}"><img src="../../bootstrap-4.3.1/assets/img/${console.image}" width="110px" height="110px"></a></td>
            <td>${console.name}</td>
            <td>${console.developer}</td>
            <td>${console.generation}th Generation</td>
            <td>${console.consoleType}</td>
            <td>${console.releasedDate?date}</td>
            <td>${console.discontinuedDate?date}</td>
            <td>${console.lifespan} Years</td>
            <td>${console.unitsSold}</td>
            <td>${console.sellPrice}</td>
            <td>${console.stock}</td>
            <td>
              <a href="/consoles/edition/?id=${console.id}">  <i class="fa fa-edit" style="font-size:25px"></i></a>
              <a href="/consoles/delete/?id=${console.id}">  <i class="fa fa-trash" style="font-size:25px;color:red"></i> </a>
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
