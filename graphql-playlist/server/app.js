const express = require('express');
const graphqlHTTP = require('express-graphql');
const schema = require('./schema/schema');
const mongoose = require('mongoose');
const sql = require("mssql");
const app = express();

app.get('/', function (req, res) {
   
    // config for your database
    var config = {
        user: 'sa',
        password: 'Rockstar@8304',
        server: 'localhost', 
        database: 'optimus' 
    };

    // connect to your database
    sql.connect(config, function (err) {
    
        if (err) console.log(err);

        // create Request object
        var request = new sql.Request();
           
        // query to the database and get the records
        request.query('select * from optimus.dbo.author', function (err, recordset) {
            
            if (err) console.log(err)

            // send records as a response
            res.send(recordset);
            sql.close();
        });
    });
});

var server = app.listen(5000, function () {
    console.log('Server is running..');
});

// bind express with graphql
app.use('/graphql', graphqlHTTP({
    schema,
    graphiql: true
}));


