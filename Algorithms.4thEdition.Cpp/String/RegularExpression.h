#pragma once
#include <string>
#include "Graph/DirectGraph.h"
namespace string
{   //  NFA
    struct nondeterministic_finite_state_automata
    {
        const std::string regex;                // match transition
        graph::digraph<size_t> digraph;         // epsilon transition
        explicit nondeterministic_finite_state_automata(const std::string& reg)
            : regex(reg)
        {
            std::stack<size_t> ops;
            for (auto i = 0; i < regex.size(); ++i)
            {
                size_t op_lpar = i;             // left parathesis
                if (regex.at(i) == '(' || regex.at(i) == '|')
                    ops.push(i);
                else if (regex.at(i) == ')')
                {
                    const auto op_or = std::move(ops.top()); ops.pop();
                    if (regex.at(op_or) == '|')
                    {
                        op_lpar = std::move(ops.top()); ops.pop();
                        digraph.add_edge(op_lpar, op_or + 1);
                        digraph.add_edge(op_or, i);
                    }
                    else op_lpar = op_or;
                }
                if (i < regex.size() - 1 && regex.at(i + 1) == '*')
                {
                    digraph.add_edge(op_lpar, i + 1);
                    digraph.add_edge(i + 1, op_lpar);
                }
                if (regex.at(i) == '(' || regex.at(i) == '|' || regex.at(i) == ')')
                    digraph.add_edge(i, i + 1);
            }
        }
        bool recognize(const std::string& text) const
        {
            std::vector<size_t> source{ 0 };
            auto reachable = digraph.reachable(source);
            for(const char c: text)
            {
                std::vector<size_t> matches;
                std::copy_if(reachable.cbegin(), reachable.cend(), std::back_inserter(matches),
                    [c, this](const size_t v) { return regex.at(v) == c || regex.at(v) == '.'; });
                for (size_t& v : matches) v += 1;
                reachable = digraph.reachable(matches);
            }
            return std::any_of(reachable.cbegin(), reachable.cend(), [this](const size_t v) { return v == regex.size(); });
        }
    };
}