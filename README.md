# NewsPortalServer

> NewsPortal server is server created for a NewPortal app. It's created in Spring Boot in Intelijj IDEA Ultimate. 
> I've created several routes for adding, editing, filtering and searching news.
> For data, I have used a simple list, but it can be done with PostgreSQL because I did it that way first.

## Running the app

> This is a Spring Boot app, so run it any way you want. I've used Intelijj IDEA Ultimate and tested it in Postman.

## Created Routes

1. GET localhost:8080/api/news/all -> returns all the news we have in storage
2. POST localhost:8080/api/news/add -> adds requested news to storage
3. POST localhost:8080/api/news/edit/{id} -> edits news with {id} id
4. GET localhost:8080/api/news/filter/{title} -> returns all the news with {title} title
5. GET localhost:8080/api/news/filter/part/{string} -> returns all the news with title that have the {string} part
6. GET localhost:8080/api/news/filter/part/details/{string} -> returns all the news with details that have the {string} part
7. GET localhost:8080/api/news/filter/part/search/{string} -> returns all the news with title or details that have the {string} part

> 5., 6., 7. are made for basic search of all the news in the app.

## Tests

> Several tests are made for testing these functionalities. Tests are located in test directory in controllers in NewsControllerTest class.

## Contributing to NewsPortalServer

To contribute to NewsPortal server, follow these steps:

1. Fork this repository.
2. Create a new branch: `git checkout -b <branch_name>`.
3. Make your changes and commit them: `git commit -m '<commit_message>'`
4. Push to the your branch: `git push origin <branch_name>`
5. Create the pull request and merge branches.

Alternatively see the GitHub documentation on [creating a pull request](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).
