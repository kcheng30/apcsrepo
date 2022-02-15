public class sumDigits {
	public int sumDigits(int n) {
  int sum = 0;
  if ( n == n % 10 )
    return n;
  else
    sum = n % 10;
  return sumDigits( n / 10 ) + sum;
}
}
