BrainForked- Gloria Lee, Jack Chen, Kevin
APCS pd08
HW93 -- exploring tree properties, extracting actionable intel from traversals
2022-05-05r
time spent:  hrs


DISCO
------------------------------------------------
* In-Order traverses from the bottom of the leftmost node. Go in the order of left-node-right. 
================================================


QCC
------------------------------------------------
* 
================================================


SELF-ASSESSMENT PROMPTS
------------------------------------------------
In which direction does a tree grow?

A tree tree grows upwards.
A java tree grows downwards.

Provide as many alternate definitions as you can for "tree," using graph terminology ("closed/open tours", "paths", "cycles", etc). Maximize clarity, succinctness.

Why is a balanced tree allowed a difference of 1 in height between right and left subtrees?

Alternate (equivalent, but more succinct?) definitions of "balanced" tree?

The height of the right and left branches of the tree can at most differ in 1. 

Is a perfect tree complete? 

A perfect tree is a complete tree since every level of it is filled. 

Is a complete tree balanced? 

A complete tree is balanced since every level is filled sometimes without the last level being filled. However, since balanced
trees can have a height difference of 1 between the right and left subtrees, it is a balanced tree. 

Is the Man Who Is Tall Happy?

I am not 6ft, I am not happy. 

What must be true of perfect trees but not others?

In perfect trees, every node/parent must have two children unless it is a node at the last level of the tree. 

================================================


C'EST POSSIBLE?
------------------------------------------------
< your explanation of whether the tree reconstruction challenge given in class is achievable or not >
================================================

The tree reconstruction is possible. Did this in my most boring class (econ haha) 
You can figure out which nodes have no right/left branches. EX: E has no left branch. If it had a left branch, the 
first node that is traversed would be the one on the left, not E. 

        -> D -> K
E -> G        -> N
        -> I  
              -> L -> O 
