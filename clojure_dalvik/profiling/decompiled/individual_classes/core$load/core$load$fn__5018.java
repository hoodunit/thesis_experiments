package clojure;

import clojure.lang.AFunction;
import clojure.lang.IFn;
import clojure.lang.RT;
import clojure.lang.Var;

public final class core$load$fn__5018 extends AFunction
{
  public static final Object const__0 = Long.valueOf(1L);
  public static final Var const__1 = (Var)RT.var("clojure.core", "pop-thread-bindings");
  Object path;

  public core$load$fn__5018(Object paramObject)
  {
    this.path = paramObject;
  }

  public Object invoke()
  {
    try
    {
      RT.load((String)((String)this.path).substring(RT.intCast(1L)));
      return null;
    }
    finally
    {
      ((IFn)const__1.getRawRoot()).invoke();
    }
  }
}

/* Location:           /home/ennus/school/thesis/thesis/experiments/clojure_android_profiling/decompiled/classes-dex2jar_unzipped/
 * Qualified Name:     clojure.core.load.fn__5018
 * JD-Core Version:    0.6.2
 */