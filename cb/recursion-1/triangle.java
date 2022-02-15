public class triangle {
	public int triangle(int rows) {
  int area = 0;
  if ( rows == 0 )
    return area;
  else
    area = rows;
  return triangle( rows - 1 ) + area;
}
}
