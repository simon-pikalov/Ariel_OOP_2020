//package class5.Ex1;
/** This enum presents the set of operations applicable on function to compose a complex function from two functions.
 * E.g.,   Plus: plus(f1(x), f2(x)),  Times: mul(f1(x), f2(x)), Divid: div(f1(x), f2(x)), Max: max(f1(x), f2(x)), Min: min(f1(x), f2(x)), Comp: comp(f1(x), f2(x)) == f1(f2(x))
 * None representing no Operation and Error representing an unknown (aka unsupported) Operation.
 * @author boaz_benmoshe
 *
 */

public enum Operation {
	Plus, Times, Divid, Max, Min, Comp , None, Error
}
