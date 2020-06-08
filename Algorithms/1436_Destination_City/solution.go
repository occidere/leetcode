package main

func destCity(paths [][]string) string {
	path := make(map[string]string)
	for _, p := range paths {
		path[p[0]] = p[1]
	}
	for _, v := range path {
		if path[v] == "" {
			return v
		}
	}
	return ""
}