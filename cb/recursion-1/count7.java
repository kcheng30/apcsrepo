public class count7 {
	public int count7(int n) {
  int total = 0;
  if ( n % 10 == n ) {
    if ( n == 7 )
      return 1;
    else
      return 0;
  }
  if ( n % 10 == 7 )
    total++;
  return count7( n / 10 ) + total;
}
}
