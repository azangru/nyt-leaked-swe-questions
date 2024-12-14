The New York Times' Parenting team would like you to produce a RESTful API in a language of your choice. This API will be used by a frontend client to produce the home page of an application, with content from two separate content producers.

## Given:

First, a GraphQL API at https://fakerql.com that provides syndicated content in response to the following query (where default count is 25):

```
{
  allPosts(count: 5) {
    id
    title
    body
    published
    createdAt
    author {
      id
      firstName
      lastName
      avatar
    }
  }
}
```

Second, an object store of your choice containing content of a similar model, accessible directly to your API at `https://localhost:9999`

## Endpoints:

_Note: with the exception of the two routes cited below, all other routes should return `404`_

### GET /health

returns JSON:

```
{ 'Status': 'OK' }
```

### GET /posts

Accepts parameters:
- `max` total results returned, default 25
- `order` chronological order of results, accepts `asc` / `desc`, default `desc`

Combines content from both sources in Given section (above) into a single ordered feed based on `createdAt` field, then returns JSON:

```
{
    posts: [
        {
            'id': 'c123',
            'title': 'Example',
            'author': {
                'id': 'a456',
                'firstName': 'ExampleFN',
                'lastName': 'ExampleLN'
            },
'createdAt': 'Mon Sep 24 2018 23:29:24 GMT+0000 (UTC)'
        }
    ]
}
```

## SOLUTION.md

Please add a file named `SOLUTION.md` with an explanation of your approach and analysis of its edge cases, along with any clarifying questions or assumptions your solution makes. Please also include specifications for how your solution would ideally be deployed, hosted, and run.