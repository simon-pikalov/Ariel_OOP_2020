package visitor;

interface ShoppingCartVisitor
{
    int visit(Book book);
    int visit(Fruit fruit);
}

