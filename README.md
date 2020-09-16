## Fetch Rewards Coding Exercise - Software Engineering - Mobile

#### Created an Android app that retrieves the data from https://fetch-hiring.s3.amazonaws.com/hiring.json.

#### [Full task](https://fetch-hiring.s3.amazonaws.com/mobile.html)

Honestly, I've never fetch data from URL. I did try and here is my implementation.

To get JSON data from URL I used [Volley](https://github.com/google/volley) library. Then, I parsed data in the next way - go through main array and parse each item to Item object. I used [GSON](https://github.com/google/gson) for easy parsing.

Using custom Item class, it's easy to manupulate with data. For example, I added "isNotNull" function to Item class. This function helps me filter out any items where "name" is blank or null. 

Afterwards, when I get all items, I used "sortWith(compareBy(..))" method to sort the results first by "listId" then by "name". 

By the way, I do not understand about this one - "Display all the items grouped by 'listId'." I suppose when you sort by "listId", it's already grouped by "listId", doesn't it? Anyway, you can check my result using screenshots below.

In result, it takes me like 2 hours to implement it and less than an hour for amend design and export to GitHub.


### Result:
<img src="https://i.imgur.com/CUoenwg.png" width="300"/>  <img src="https://i.imgur.com/jnTzjCY.png" width="300"/>  <img src="https://i.imgur.com/zVc88fg.png" width="300"/> </br>
<img src="https://i.imgur.com/dIj9Ofz.png" width="300"/>  <img src="https://i.imgur.com/nN0N1lp.png" width="300"/>  <img src="https://i.imgur.com/yCIeta7.png" width="300"/>
