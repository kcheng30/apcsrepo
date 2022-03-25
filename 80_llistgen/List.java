/***
 * interface List
 * subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 *
 * If placed in current working dir, will be consulted instead of
 *  built-in Java library interface.
 *
 * new in version 2.0: 
 * REMOVE-AT-INDEX
 * ADD-AT-INDEX
 **/

public interface List<ask>
{
  //add node to list, containing input String as its data
  public boolean add( ask x );

  //insert at specified index
  public void add( int index, ask newVal );

  //remove node from list, return its data
  public ask remove( int index );

  //return data in element at position i
  public ask get( int i );

  //overwrite data in element at position i
  public ask set( int i, ask x );

  //return length of list
  public int size();

}//end interface
