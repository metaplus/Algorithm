#pragma once
namespace leetcode
{
    struct filter
    {
        struct all {};
        struct first {};
        struct last {};
        template<size_t... Indexes>
        struct select : std::index_sequence<Indexes...> {};
    };
    struct result
    {
        struct value
        {
            template<typename Value>
            static bool apply(Value expr) { return static_cast<bool>(expr); }
        };
        struct callable
        {
            template<typename Callable>
            static bool apply(Callable&& expr) { return value::apply(expr()); }
        };
        struct fallback
        {
            template<typename Anything>
            static bool apply(Anything)
            {
                static_assert(false, "static dispatched in fallback branch");
                return false;
            }
        };
    };
    struct expect
    {
        template<typename Solution>
        static bool of_one(Solution&& expr)
        {
            using concise_type = std::decay_t<Solution>;
            return 
                std::conditional_t<std::is_arithmetic_v<concise_type>, result::value,
                std::conditional_t<!std::is_move_assignable_v<concise_type>, result::callable,  //mock is_lambda type trait
                result::fallback>>::apply(std::forward<Solution>(expr));
        }
        template<size_t ...Indexes, typename ...Solutions>
        static std::array<bool, sizeof...(Indexes)> results_from_tuple(std::tuple<Solutions...>& expr, std::index_sequence<Indexes...>)
        {
            return { of_one(std::get<Indexes>(expr))... };
        }
        template<typename Filter, typename ...Solutions>
        static bool of(Solutions&& ...exprs)
        {
            using indexes =
                std::conditional_t<std::is_same_v<Filter, filter::all>, std::index_sequence_for<Solutions...>,
                std::conditional_t<std::is_same_v<Filter, filter::first>, std::index_sequence<0>,
                std::conditional_t<std::is_same_v<Filter, filter::last>, std::index_sequence<sizeof...(Solutions)-1>,
                Filter>>>;
            auto solution_tuple = std::make_tuple(std::forward<Solutions>(exprs)...);
            auto result_array = results_from_tuple(solution_tuple, indexes{});
            return std::all_of(result_array.begin(), result_array.end(), [](bool b) { return b; });
        }
    };
}