<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>${title}</title>

    <link href="../../bootstrap-4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../bootstrap-4.3.1/style/creation-form.css" rel="stylesheet">

</head>
<body class="bg-light">
<div class="container">
    <div class="py-5 text-center">
        <h1>Edit console</h1>
    </div>

    <div class="center-container">


        <div class="row">

            <div class="col-md-8 order-md-1">
                <h4 class="mb-3">Write the information of the console</h4>

                <form method="post" action="/consoles/edit/?id=${console.id}" class="needs-validation" enctype="multipart/form-data" novalidate>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="name">Console name</label>
                            <input type="text" class="form-control" value="${console.name}" id="name" name="name" placeholder="Console name"  required>

                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="developer">Developer</label>
                            <select class="custom-select d-block w-100" id="developer" name="developer" required>
                                <option value="${console.developer}">${console.developer}</option>
                                <option value="Sony">Sony</option>
                                <option value="Microsoft">Microsoft</option>
                                <option value="Nintendo">Nintendo</option>
                                <option value="Sega">Sega</option>
                            </select>

                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="consoleType">Console type</label>
                        <select class="custom-select d-block w-100"  id="consoleType" name="consoleType" required>
                            <option value="${console.consoleType}">${console.consoleType}</option>
                            <option value="Home Console">Home console</option>
                            <option value="Handheld Console">Handheld console</option>
                        </select>

                    </div>

                    <div class="mb-3">
                        <label for="generation">Generation</label>
                        <select class="custom-select d-block w-100" id="generation" name="generation" required>
                            <option value="${console.generation}">${console.generation}th generation</option>
                            <option value="3">3rd generation</option>
                            <option value="4">4th generation</option>
                            <option value="5">5th generation</option>
                            <option value="6">6th generation</option>
                            <option value="7">7th generation</option>
                            <option value="8">8th generation</option>
                        </select>

                    </div>


                    <div class="mb-3">
                        <label for="releasedDate">Released date</label>
                        <div class="input-group">
                            <input type="date" class="form-control" value="${console.releasedDate}" id="releasedDate" name="releasedDate" placeholder="Released date" required>

                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="discontinuedDate">Discontinued date</label>
                        <div class="input-group">
                            <input type="date" class="form-control" value="${console.discontinuedDate}" id="discontinuedDate" name="discontinuedDate" placeholder="Discontinued date" required>

                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="unitsSold">Units sold</label>
                        <div class="input-group">
                            <input type="number" class="form-control" value="${console.unitsSold}" id="unitsSold" name="unitsSold" placeholder="Units sold" required>

                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="sellPrice">Selling price</label>
                        <div class="input-group">
                            <input type="number" value="${console.sellPrice}" class="form-control" id="sellPrice" name="sellPrice" placeholder="Selling price" required>

                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="stock">Stock</label>
                        <div class="input-group">
                            <input type="number" value="${console.stock}" class="form-control" id="stock" name="stock" placeholder="Stock" required>

                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="idPredecessorConsole">Predecessor console</label>

                        <div class="input-group">
                            <select class="form-control" name="idPredecessorConsole">
                                <#list predecessorConsoles as console0>

                                    <option value="${console0.id}" >${console0.name} - ${console0.developer} - ${console0.consoleType}</option>

                                </#list>
                            </select>
                        </div>

                    </div>

                    <div class="mb-3">
                        <label for="idSuccessorConsole">Successor console</label>

                        <div class="input-group">
                            <select class="form-control" name="idSuccessorConsole">
                                <#list successorConsoles as console1>

                                    <option value="${console1.id}" >${console1.name} - ${console1.developer} - ${console1.consoleType}</option>

                                </#list>
                            </select>
                        </div>

                    </div>

                    <div class="mb-3">
                        <label for="image">Picture of the console</label>
                        <div class="input-group">
                            <input type="file" class="form-control" value="${console.image}" id="image" name="image" placeholder="Picture of the console">

                        </div>
                    </div>

                    <hr class="mb-4">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Save console</button>
                    <hr class="mb-4">
                    <a class="btn btn-danger btn-lg btn-block" href="/consoles/admin" role="button">Cancel</a>
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
