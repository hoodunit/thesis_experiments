package clojure;

import clojure.lang.IFn;
import clojure.lang.Indexed;
import clojure.lang.RT;
import clojure.lang.RestFn;
import clojure.lang.Util;
import clojure.lang.Var;

public final class core$load extends RestFn
{
  public static final Var const__0 = (Var)RT.var("clojure.core", "seq");
  public static final Object const__1 = Long.valueOf(0L);
  public static final Var const__10 = (Var)RT.var("clojure.core", "flush");
  public static final Var const__11 = (Var)RT.var("clojure.core", "check-cyclic-dependency");
  public static final Var const__12 = (Var)RT.var("clojure.core", "=");
  public static final Var const__13 = (Var)RT.var("clojure.core", "first");
  public static final Var const__14 = (Var)RT.var("clojure.core", "*pending-paths*");
  public static final Var const__15 = (Var)RT.var("clojure.core", "push-thread-bindings");
  public static final Var const__16 = (Var)RT.var("clojure.core", "hash-map");
  public static final Var const__17 = (Var)RT.var("clojure.core", "conj");
  public static final Var const__18 = (Var)RT.var("clojure.core", "unchecked-inc");
  public static final Var const__19 = (Var)RT.var("clojure.core", "chunked-seq?");
  public static final Var const__2 = (Var)RT.var("clojure.core", "<");
  public static final Var const__20 = (Var)RT.var("clojure.core", "chunk-first");
  public static final Var const__21 = (Var)RT.var("clojure.core", "chunk-rest");
  public static final Var const__22 = (Var)RT.var("clojure.core", "int");
  public static final Var const__23 = (Var)RT.var("clojure.core", "count");
  public static final Var const__24 = (Var)RT.var("clojure.core", "next");
  public static final Var const__3 = (Var)RT.var("clojure.core", "str");
  public static final Var const__4 = (Var)RT.var("clojure.core", "root-directory");
  public static final Var const__5 = (Var)RT.var("clojure.core", "ns-name");
  public static final Var const__6 = (Var)RT.var("clojure.core", "*ns*");
  public static final Object const__7 = Character.valueOf('/');
  public static final Var const__8 = (Var)RT.var("clojure.core", "*loading-verbosely*");
  public static final Var const__9 = (Var)RT.var("clojure.core", "printf");

  public Object doInvoke(Object paramObject)
  {
    Object localObject1 = ((IFn)const__0.getRawRoot()).invoke(paramObject);
    Object localObject2 = null;
    long l1 = 0L;
    long l2 = 0L;
    label68: label235: Object localObject3;
    while (true)
    {
      if (l2 < l1)
      {
        Object localObject9 = ((Indexed)localObject2).nth(RT.intCast(l2));
        Object localObject10;
        if (((String)localObject9).startsWith((String)"/"))
        {
          localObject10 = localObject9;
          Object localObject11 = const__8.get();
          if ((localObject11 != null) && (localObject11 != Boolean.FALSE))
          {
            ((IFn)const__9.getRawRoot()).invoke("(clojure.core/load \"%s\")\n", localObject10);
            ((IFn)const__10.getRawRoot()).invoke();
          }
          ((IFn)const__11.getRawRoot()).invoke(localObject10);
          if (!Util.equiv(localObject10, ((IFn)const__13.getRawRoot()).invoke(const__14.get())))
            break label235;
        }
        while (true)
        {
          l2 += 1L;
          break;
          localObject10 = ((IFn)const__3.getRawRoot()).invoke(((IFn)const__4.getRawRoot()).invoke(((IFn)const__5.getRawRoot()).invoke(const__6.get())), const__7, localObject9);
          break label68;
          ((IFn)const__15.getRawRoot()).invoke(((IFn)const__16.getRawRoot()).invoke(const__14, ((IFn)const__17.getRawRoot()).invoke(const__14.get(), localObject10)));
          core.load.fn__5016 localfn__5016 = new core.load.fn__5016(localObject10);
          ((IFn)localfn__5016).invoke();
        }
      }
      localObject3 = ((IFn)const__0.getRawRoot()).invoke(localObject1);
      if ((localObject3 == null) || (localObject3 == Boolean.FALSE))
        break label737;
      Object localObject4 = ((IFn)const__19.getRawRoot()).invoke(localObject3);
      if ((localObject4 == null) || (localObject4 == Boolean.FALSE))
        break;
      Object localObject8 = ((IFn)const__20.getRawRoot()).invoke(localObject3);
      localObject1 = ((IFn)const__21.getRawRoot()).invoke(localObject3);
      l1 = RT.intCast(RT.count(localObject8));
      l2 = RT.intCast(0L);
      localObject2 = localObject8;
    }
    Object localObject5 = ((IFn)const__13.getRawRoot()).invoke(localObject3);
    Object localObject6;
    if (((String)localObject5).startsWith((String)"/"))
    {
      localObject6 = localObject5;
      label472: Object localObject7 = const__8.get();
      if ((localObject7 != null) && (localObject7 != Boolean.FALSE))
      {
        ((IFn)const__9.getRawRoot()).invoke("(clojure.core/load \"%s\")\n", localObject6);
        ((IFn)const__10.getRawRoot()).invoke();
      }
      ((IFn)const__11.getRawRoot()).invoke(localObject6);
      if (!Util.equiv(localObject6, ((IFn)const__13.getRawRoot()).invoke(const__14.get())))
        break label658;
    }
    while (true)
    {
      localObject1 = ((IFn)const__24.getRawRoot()).invoke(localObject3);
      l1 = 0L;
      l2 = 0L;
      localObject2 = null;
      break;
      localObject6 = ((IFn)const__3.getRawRoot()).invoke(((IFn)const__4.getRawRoot()).invoke(((IFn)const__5.getRawRoot()).invoke(const__6.get())), const__7, localObject5);
      break label472;
      label658: ((IFn)const__15.getRawRoot()).invoke(((IFn)const__16.getRawRoot()).invoke(const__14, ((IFn)const__17.getRawRoot()).invoke(const__14.get(), localObject6)));
      core.load.fn__5018 localfn__5018 = new core.load.fn__5018(localObject6);
      ((IFn)localfn__5018).invoke();
    }
    label737: return null;
  }

  public int getRequiredArity()
  {
    return 0;
  }
}

/* Location:           /home/ennus/school/thesis/thesis/experiments/clojure_android_profiling/decompiled/individual_classes/core$load$fn__5018/
 * Qualified Name:     clojure.core.load
 * JD-Core Version:    0.6.2
 */