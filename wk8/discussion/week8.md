# Week 8 – Lists

### Array lists and linked lists are both implementations of lists. Give an example of a situation where an array list would be the better choice and one where a linked list would. Explain the reasons in each case.

In general, I think that ArrayList is better for getting an manipulating data, since it can be done in O(1). So, it would be good storing objects like a database. The gotcha comes from the fact that ArrayList must be resized when its underlying array meets its limit. So the LinkedLists are better for simply adding and removing with no regards to index. 

If I was going to find a use for LinkedLists, I would think of maybe a web browser storing history for the "back" button. When you click on a new link, you will have context to its previous index. So if you press back a ton of times, you are iterating over the linked list instead of searching for an index. In the same vein, I think a LinkedList would be good for "undo" and "redo" since you will always have context to what was previous and next.

In the attached file, I messed around with time to show the (albeit small) difference in the resizing of the ArrayList. 