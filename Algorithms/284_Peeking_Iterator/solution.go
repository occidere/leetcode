package main

/*   Below is the interface for Iterator, which is already defined for you.
 *
 *   type Iterator struct {
 *
 *   }
 *
 *   func (this *Iterator) hasNext() bool {
 *		// Returns true if the iteration has more elements.
 *   }
 *
 *   func (this *Iterator) next() int {
 *		// Returns the next element in the iteration.
 *   }
 */

type PeekingIterator struct {
	buf [1]int
	empty bool
	it *Iterator
}

func Constructor(it *Iterator) *PeekingIterator {
	p := PeekingIterator{empty: true, it: it}
	if it.hasNext() {
		p.buf[0] = it.next()
		p.empty = false
	}
	return &p
}

func (p *PeekingIterator) hasNext() bool {
	return !p.empty
}

func (p *PeekingIterator) next() int {
	ret := p.buf[0]
	if p.it.hasNext() {
		p.buf[0] = p.it.next()
	} else {
		p.empty = true
	}
	return ret
}

func (p *PeekingIterator) peek() int {
	return p.buf[0]
}