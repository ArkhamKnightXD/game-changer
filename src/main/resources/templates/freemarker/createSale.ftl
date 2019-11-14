<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="generator" content="">
    <title>${title}</title>

    <link href="../../bootstrap-4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../bootstrap-4.3.1/style/creation-form.css" rel="stylesheet">

</head>
<body class="bg-light">
<div class="container">
    <div class="py-5 text-center">
        <h1>Sale Form</h1>
    </div>

  <div class="center-container">

    <div class="row">

        <div class="col-md-8 order-md-1">
            <h4 class="mb-3">Selling page</h4>

            <form method="post" action="/sales/create" class="needs-validation" enctype="multipart/form-data" novalidate>
                    <div class="mb-3">
                        <label for="idClient">Select the client</label>

                        <div class="input-group">
                            <select class="form-control" name="idClient" required>
                                <#list clients as client>
                                    <option value="${client.id}" >${client.name} - ${client.lastName} - ${client.address} - ${client.phone}</option>
                                </#list>
                            </select>
                        </div>
                    </div>


                <div class="mb-3">
                    <label for="idConsoles">Select the console</label>

                    <div class="input-group">
                        <select multiple class="form-control" name="idConsoles" required>
                            <#list consoles as console>
                                <option value="${console.id}" >${console.name} - ${console.developer} - ${console.consoleType} - $${console.sellPrice}</option>
                            </#list>
                        </select>
                    </div>

                </div>

                <div class="mb-3">
                    <label for="idVideoGames">Select the VideoGames</label>

                    <div class="input-group">
                        <select multiple class="form-control" name="idVideoGames" required>
                            <#list videogames as videogame>
                                <option value="${videogame.id}" >${videogame.name} - ${videogame.developer} - ${videogame.genre} - $${videogame.sellPrice}</option>
                            </#list>
                        </select>
                    </div>

                </div>

                <div class="mb-3">
                    <label for="soldDate">Selling Date</label>
                    <div class="input-group">
                        <input type="date" class="form-control" id="soldDate" name="soldDate" placeholder="Selling Date" required>

                    </div>
                </div>


                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Sell</button>
                <hr class="mb-4">
                <a class="btn btn-danger btn-lg btn-block" href="/sales/" role="button">Cancel</a>
            </form>
        </div>
    </div>
  </div>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2019 Arkham-Store</p>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
    </footer>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script>window.jQuery || document.write('<script src="../../bootstrap-4.3.1/dist/js/jquery-3.2.1.slim.min.js"><\/script>')</script><script src="../../bootstrap-4.3.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="../../bootstrap-4.3.1/dist/js/form-validation.js"></script></body>
</html>
