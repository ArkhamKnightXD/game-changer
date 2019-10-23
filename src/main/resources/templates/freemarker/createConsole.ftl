<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>${title}</title>

    <link href="../../bootstrap-4.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link href="../../bootstrap-4.3.1/style/creation-form.css" rel="stylesheet">

</head>
<body class="bg-light">
<div class="container">
    <div class="py-5 text-center">
        <h1>Console Form</h1>
    </div>


  <div class="center-container">


    <div class="row">

        <div class="col-md-8 order-md-1">
            <h4 class="mb-3">Write the information of the console</h4>

            <form method="post" action="/consoles/create" class="needs-validation" enctype="multipart/form-data" novalidate>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="name">Console name</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Console name"  required>

                    </div>

                    <div class="col-md-6 mb-3">
                        <label for="developer">Developer</label>
                        <input type="text" class="form-control" id="developer" name="developer" placeholder="Developer"  required>

                    </div>
                </div>

                <div class="mb-3">
                    <label for="consoleType">Console type</label>
                    <select class="custom-select d-block w-100" id="consoleType" name="consoleType" required>
                        <option value="">Choose...</option>
                        <option value="Home Console">Home console</option>
                        <option value="Handheld Console">Handheld console</option>
                    </select>

                </div>

                <div class="mb-3">
                    <label for="generation">Generation</label>
                    <select class="custom-select d-block w-100" id="generation" name="generation" required>
                        <option value="">Choose...</option>
                        <option value="3rd generation">3rd generation</option>
                        <option value="4th generation">4th generation</option>
                        <option value="5th generation">5th generation</option>
                        <option value="6th generation">6th generation</option>
                        <option value="7th generation">7th generation</option>
                        <option value="8th generation">8th generation</option>
                    </select>

                </div>


                <div class="mb-3">
                    <label for="releasedDate">Released date</label>
                    <div class="input-group">
                        <input type="date" class="form-control" id="releasedDate" name="releasedDate" placeholder="Released date" required>

                    </div>
                </div>

                <div class="mb-3">
                    <label for="discontinuedDate">Discontinued date</label>
                    <div class="input-group">
                        <input type="date" class="form-control" id="discontinuedDate" name="discontinuedDate" placeholder="Discontinued date" required>

                    </div>
                </div>

                <div class="mb-3">
                    <label for="unitsSold">Units sold</label>
                    <div class="input-group">
                        <input type="number" class="form-control" id="unitsSold" name="unitsSold" placeholder="Units sold" required>

                    </div>
                </div>

                <div class="mb-3">
                    <label for="image">Picture of the console</label>
                    <div class="input-group">
                        <input type="file" class="form-control" id="image" name="image" placeholder="Picture of the console" required>

                    </div>
                </div>

                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Save console</button>
                <hr class="mb-4">
                <a class="btn btn-danger btn-lg btn-block" href="/consoles/" role="button">Cancel</a>
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
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../bootstrap-4.3.1/dist/js/jquery-3.2.1.slim.min.js"><\/script>')</script><script src="../../bootstrap-4.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
<script src="../../bootstrap-4.3.1/dist/js/form-validation.js"></script></body>
</html>
