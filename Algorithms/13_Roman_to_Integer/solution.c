/**
 * @author occidere
 * @since 2019-06-01
 * Blog: https://blog.naver.com/occidere
 * Github: https://github.com/occidere
 */
#include <stdio.h>
#include <string.h>

int romanToInt(char *s)
{
    int n = 0, num = 0, len = strlen(s);
    for (int i = 0; i < len; i++, num += n)
    {
        char c = *(s + i), c2;
        if (c == 'I')
        {
            if (i < len - 1)
            {
                c2 = *(s + (++i));
                switch (c2)
                {
                case 'V':
                    n = 4;
                    break;
                case 'X':
                    n = 9;
                    break;
                default:
                    i--;
                    n = 1;
                }
            }
            else
            {
                n = 1;
            }
        }
        else if (c == 'X')
        {
            if (i < len - 1)
            {
                c2 = *(s + (++i));
                switch (c2)
                {
                case 'L':
                    n = 40;
                    break;
                case 'C':
                    n = 90;
                    break;
                default:
                    i--;
                    n = 10;
                }
            }
            else
            {
                n = 10;
            }
        }
        else if (c == 'C')
        {
            if (i < len - 1)
            {
                c2 = *(s + (++i));
                switch (c2)
                {
                case 'D':
                    n = 400;
                    break;
                case 'M':
                    n = 900;
                    break;
                default:
                    i--;
                    n = 100;
                }
            }
            else
            {
                n = 100;
            }
        }
        else
        {
            switch (c)
            {
            case 'V':
                n = 5;
                break;
            case 'L':
                n = 50;
                break;
            case 'D':
                n = 500;
                break;
            case 'M':
                n = 1000;
                break;
            }
        }
    }
    return num;
}
