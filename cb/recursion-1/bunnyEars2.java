public class bunnyEars2 {
public int bunnyEars2(int bunnies) {
  int ears = 0;
  if ( bunnies == 0 )
    return ears;
  if ( bunnies % 2 == 1 )
    ears = 2;
  else 
    ears = 3;
  return ears + bunnyEars2( bunnies - 1 );
}
}
